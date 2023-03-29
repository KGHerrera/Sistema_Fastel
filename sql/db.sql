/* TABLAS DE LA BASE DE DATOS */
CREATE TABLE clientes (
    id_cliente INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    rfc VARCHAR(14) NOT NULL,
    telefono VARCHAR(12) NOT NULL,
    fecha_registro DATE NOT NULL
);


CREATE TABLE habitaciones (
    id_habitacion INT IDENTITY(1,1) PRIMARY KEY,
    tipo_habitacion VARCHAR(15) NOT NULL,
    disponible BIT NOT NULL,
    baja_temporal BIT NOT NULL,
    precio_noche DECIMAL(12, 2) NOT NULL
);

CREATE TABLE reservaciones (
    id_reservacion INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    fecha_reservacion DATE NOT NULL,
    vigencia DATE NOT NULL,
    costo_total DECIMAL(14,2) NOT NULL,
    fk_id_habitacion INT FOREIGN KEY REFERENCES habitaciones(id_habitacion) NOT NULL,
    fk_id_cliente INT FOREIGN KEY REFERENCES clientes(id_cliente) NOT NULL
);

CREATE TABLE reservaciones_canceladas (
    id_reservacion INT,
    fecha_reservacion DATE NOT NULL,
    vigencia DATE NOT NULL,
    costo_total DECIMAL(14,2) NOT NULL,
    fk_id_habitacion INT FOREIGN KEY REFERENCES habitaciones(id_habitacion) NOT NULL,
    fk_id_cliente INT FOREIGN KEY REFERENCES clientes(id_cliente) NOT NULL
);


CREATE TABLE empleados (
  id_empleado INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
  nombre VARCHAR(25) NOT NULL,
  apellido VARCHAR(25) NOT NULL,
  rfc VARCHAR(14) NOT NULL,
  telefono VARCHAR(12) NOT NULL,
  puesto VARCHAR(15) NOT NULL,
  sueldo DECIMAL(10,2) NOT NULL
);

CREATE TABLE usuarios (
    id_usuario INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    usuario VARCHAR(20) NOT NULL,
    password VARBINARY(64) NOT NULL,
    tipo_usuario VARCHAR(20) NOT NULL,
    fk_id_empleado INT FOREIGN KEY REFERENCES empleados(id_empleado) NOT NULL
);

/* INSERCIONES DE PRUEBA */
INSERT INTO empleados VALUES("k", "herrera", "KHERR2891", "494120412", "gerente", 99999.99);
INSERT INTO usuarios VALUES("pinkamena", HASHBYTES('SHA2_512', 'pinkamena'), "administrador", 1);

/* PRUEBA DE ENCRIPTACION DE CONTRASEÑAS EN SQL SERVER
SELECT COUNT(*) FROM usuarios
WHERE usuario = 'pinkamena' AND password = HASHBYTES('SHA2_512', 'pinkamena'); */


/* TRIGGER DE AUDITORIA PARA ELIMINACIONES EN LA TABLA RESERVACIONES (CANCELAR RESERVACION)*/
CREATE TRIGGER tr_reservaciones_canceladas ON reservaciones
AFTER DELETE
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO reservaciones_canceladas (id_reservacion, fecha_reservacion, vigencia, costo_total, fk_id_habitacion, fk_id_cliente)
    SELECT id_reservacion, fecha_reservacion, vigencia, costo_total, fk_id_habitacion, fk_id_cliente
    FROM DELETED;
END;


/* VISTA PARA RESERVACIONES JOIN A LA TABLA HABITACIONES Y CLIENTES */
CREATE VIEW v_reservaciones
AS
SELECT 
    id_reservacion,
    fecha_reservacion,
    vigencia,
    costo_total,
    h.id_habitacion,
    h.precio_noche,
    h.tipo_habitacion,
    c.nombre + ' ' + c.apellido as nombre_cliente,
    c.rfc
FROM 
    reservaciones r 
    INNER JOIN habitaciones h ON r.fk_id_habitacion = h.id_habitacion
    INNER JOIN clientes c ON r.fk_id_cliente = c.id_cliente;

/* CONSULTA DEL REPORTE
SELECT fecha_reservacion, nombre_cliente, vigencia, costo_total, tipo_habitacion FROM v_reservaciones */

/* FUNCION PARA VERIFICAR USUARIOS USANDO ENCRIPTADO */
CREATE FUNCTION verificarUsuario (@usuario VARCHAR(20), @password VARCHAR(64))
RETURNS VARCHAR(60)
AS
BEGIN
    DECLARE @rtipo VARCHAR(20)
    DECLARE @rusuario VARCHAR(20)

    SELECT @rtipo = tipo_usuario FROM usuarios WHERE usuario = @usuario AND password = HASHBYTES('SHA2_512', @password)
    SELECT @rusuario = usuario FROM usuarios WHERE usuario = @usuario AND password = HASHBYTES('SHA2_512', @password)
      
    RETURN @rusuario + ' ' + @rtipo
END;

/* EJEMPLO DE LLAMADO A LA FUNCION ANTERIOR
SELECT dbo.verificarUsuario('pinkamena', 'pinkamena');*/


/* FORMA DE CREAR INIDICES PARA LA TABLA EMPLEADOS A PARTIR DEL CAMPO NOMBRES */
CREATE INDEX idx_nombre ON empleados (nombre);

/* LIMITE DE CONEXIONES A SOLO 2 EN SQL SERVER */
EXEC sp_configure 'show advanced options', 1;  
GO  
RECONFIGURE ;  
GO  
EXEC sp_configure 'user connections', 2 ;  
GO  
RECONFIGURE;  
GO

/* COMANDO PARA MOSTRAR EL NUMERO DE CONEXIONES MAX MIN Y CONFIGURADAS
sp_configure 'user connections'*/

/* PARTICIONES */
sp_helpdb [fastel]

USE fastel
GO
ALTER DATABASE fastel
ADD FILEGROUP fastel_1
GO
ALTER DATABASE fastel
ADD FILEGROUP fastel_2
GO

ALTER DATABASE fastel
    ADD FILE
    (
        NAME = fastel_1,
        FILENAME = 'C:\fastel\fastel_1.ndf',
            SIZE = 10 MB,
            MAXSIZE = UNLIMITED,
            FILEGROWTH = 64 MB
    ) TO FILEGROUP fastel_1

ALTER DATABASE fastel
    ADD FILE
    (
        NAME = fastel_2,
        FILENAME = 'C:\fastel\fastel_2.ndf',
            SIZE = 10 MB,
            MAXSIZE = UNLIMITED,
            FILEGROWTH = 64 MB
    ) TO FILEGROUP fastel_2


/* ESQUEMA DE PARTICIONADO */

CREATE PARTITION FUNCTION pf_clientes_id(INT)
AS RANGE LEFT FOR VALUES (100, 200, 300, 500);

CREATE PARTITION SCHEME ps_clientes_id
AS PARTITION pf_clientes_id
TO ([PRIMARY], [PRIMARY], [PRIMARY], [PRIMARY], [PRIMARY]);

CREATE TABLE clientes (
    id_cliente INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    rfc VARCHAR(14) NOT NULL,
    telefono VARCHAR(12) NOT NULL,
    fecha_registro DATE NOT NULL
)
ON ps_clientes_id(id_cliente);

/* MOSTRAR LAS PARTICIONES DE LA TABLA */
SELECT 
    ps.name AS partition_scheme_name, 
    pf.name AS partition_function_name,
    p.partition_number,
    p.partition_id,
    p.rows
FROM sys.partitions p 
JOIN sys.indexes i ON p.object_id = i.object_id AND p.index_id = i.index_id 
JOIN sys.partition_schemes ps ON ps.data_space_id = i.data_space_id 
JOIN sys.partition_functions pf ON ps.function_id = pf.function_id 
WHERE p.object_id = OBJECT_ID('clientes');
