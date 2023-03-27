# Sistema_Fastel
<h1>Proyecto de gestión de reservaciones de hotel</h1>
<p>Este proyecto es una aplicación de gestión de reservaciones de hotel desarrollada en Java con una base de datos en SQL Server. Permite realizar operaciones CRUD (crear, leer, actualizar y eliminar) sobre los datos de clientes, habitaciones, reservaciones y empleados.</p>
<h2>Requerimientos</h2>
<ul>
<li>Java 8 o superior</li>
<li>SQL Server</li>
<li>JDBC Driver para SQL Server</li>
</ul>
<h2>Configuración de la base de datos</h2>
<ol>
<li>Crear una base de datos en SQL Server.</li>
<li>Ejecutar el script <code>db.sql</code> ubicado en la carpeta <code>sql</code> para crear las tablas y procedimientos almacenados necesarios.</li>
<li>Modificar el archivo <code>config.properties</code> ubicado en la carpeta <code>src</code> con los datos de conexión a la base de datos creada.</li>
</ol>
<h2>Uso de la aplicación</h2>
<p>Para utilizar la aplicación:</p>
<ol>
<li>Clonar el repositorio o descargar los archivos del proyecto.</li>
<li>Importar el proyecto en un IDE de Java.</li>
<li>Ejecutar la aplicación.</li>
</ol>
<h2>Funcionalidades</h2>
<p>La aplicación permite realizar las siguientes operaciones:</p>
<ul>
<li>Clientes
  <ul>
  <li>Alta de clientes.</li>
  <li>Baja de clientes.</li>
  <li>Modificación de clientes.</li>
  <li>Consulta de clientes.</li>
  </ul>
</li>
<li>Habitaciones
  <ul>
  <li>Alta de habitaciones.</li>
  <li>Baja de habitaciones.</li>
  <li>Modificación de habitaciones.</li>
  <li>Consulta de habitaciones.</li>
  </ul>
</li>
<li>Reservaciones
  <ul>
  <li>Alta de reservaciones.</li>
  <li>Baja de reservaciones.</li>
  <li>Modificación de reservaciones.</li>
  <li>Consulta de reservaciones.</li>
  </ul>
</li>
<li>Empleados
  <ul>
  <li>Alta de empleados.</li>
  <li>Baja de empleados.</li>
  <li>Modificación de empleados.</li>
  <li>Consulta de empleados.</li>
  </ul>
</li>
</ul>
<h2>Contribuir</h2>
<p>Si deseas contribuir al desarrollo de la aplicación, por favor sigue los siguientes pasos:</p>
<ol>
<li>Haz un fork del proyecto.</li>
<li>Crea una nueva rama con tus cambios: <code>git checkout -b mi-rama</code></li>
<li>Realiza los cambios y haz commit: <code>git commit -am "Agrego mi cambio"</code></li>
<li>Sube los cambios a tu fork: <code>git push origin mi-rama</code></li>
<li>Crea un pull request desde tu fork a la rama principal del proyecto.</li>
</ol>
