# Introducción
La idea es hacer una simulación en la que basándonos en unos partidos que concurren a las
elecciones y sus candidatos, y mediante las votaciones de los inscritos se puedan repartir los
escaños asignados a una determinada circunscripción electoral.
Como pretende ser una aplicación genérica para cualquier convocatoria electoral, también se
debe recoger información sobre:
* Tipo de elección de que se trate (generales, autonómicas, europeas o locales).
* Provincia por la que se implanta la aplicación.
* Número de cargos electos a designar.

Cada votante deberá registrar sus datos personales para poder ejercer el voto.
Información necesaria que se deberá registrar previamente en la base de datos para que la
aplicación funcione: partidos, candidatos (junto con su orden de elección) y convocatoria.
Partiendo de toda esta información, existen dos roles de usuarios diferentes que podrán acceder
a funcionalidades diferentes (administrador y usuario).
El administrador de la plataforma podrá realizar las operaciones oportunas para que el proceso
de elecciones se desarrolle correctamente. Dichas operaciones pueden resumirse en:
* Listado de censo.
Lo podrá realizar en cualquier momento del proceso y obtendrá todos los datos de los
votantes y si ha votado o no.
* Apertura y Cierre del escrutinio.
Hasta que el administrador no habilite la opción, no se podrá comenzar a votar. De la
misma forma, cuando finalice dicho plazo se procederá al cierre de la opción.
* Presentación de resultados.
Según los votos obtenidos por cada partido, y aplicando la ley de D’hont mostrará la
información que estime oportuna y sobre todo, los candidatos que han salido elegidos,
teniendo en cuenta que cada circunscripción tiene un número distinto de puestos
electos.
El usuario (votante) podrá ejercer la opción de:
* Darse de alta.
* Darse de baja siempre y cuando no haya votado.
* Modificar sus datos personales (incluyendo password), si no ha votado.
* Ver resultados de las votaciones.

# Aspectos de implementación.
* El sitio web se desarrollará con tecnología J2EE.
* Adoptaremos el paradigma MVC con capa DAO adicional.
* Se implementarán transacciones cuando sea preciso.
* Para las conexiones a la base de datos utilizaremos el patrón de diseño Singleton que
nos asegura una única conexión.
* Las órdenes SQL serán ejecutadas con sentencias preparadas para evitar SQL
injection.
* Si es oportuno, se utilizarán Dispatcher para llamar a distintos servlets.
* Los distintos Servlets se configurarán en un único fichero web.xml.
* Se utilizará encriptación de la contraseña del votante.

# BACKEND
JAVA J2EE
# FRONTEND
Bootstrap
