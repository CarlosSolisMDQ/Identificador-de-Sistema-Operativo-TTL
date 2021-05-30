# Identificador-de-Sistema-Operativo-TTL

<p>Hace un par de meses empecé a aprender java y viendo un video de S4vitar de la resolucion de una maquina de **Hack the box** él pone un pequeño programa para averiguar que SO corre la maquina objetivo sin usar nmap, solo dependiendo de la informacion que nos retorna un Ping a la ip de la victima recogiendo el valor de **TTL**</p>

<p>La idea es que si el ttl esta en el rango de 0 a 64 es una maquina linux (o probablemente lo sea) y si esta entre 65 y 128 es una maquina windows</p>

<p>**S4vitar** hizo el codigo en Python pero a mi la verdad no me gusta así que traduje la funcionalidad a Java. Mi primera version ademas de visualizarlo guardaba el output del ping en un archivo, pero lo saqué porque era al pedo la verdad</p>
