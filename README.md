Implementar en JavaFX una calculadora de números complejos, que permita sumar, restar, multiplicar y dividir números de este tipo.

Se deberá crear un bean JavaFX de nombre "Complejo" con las propiedades "real" e "imaginario" de tipo "Double": "DoubleProperty".

El aspecto de la interfaz será el siguiente:
Las operaciones a realizar son las siguientes:

Suma:(a,b)+(c,d)=(a+c,\,b+d)
Resta: (a,b)-(c,d)=(a-c,\,b-d)
Multiplicación: (a,b)\cdot (c,d)=(ac-bd,ad+bc)
División: {\frac  {(a,b)}{(c,d)}}={(ac+bd,\,bc-ad) \over c^{2}+d^{2}}=\left({ac+bd \over c^{2}+d^{2}},{bc-ad \over c^{2}+d^{2}}\right)
Donde "a" y "c" son las partes reales de primer y segundo operando respectivamente, y "b" y "d" sus partes imaginarias.

El funcionamiento será el siguiente:

Se selecciona la operación a realizar en la lista desplegable (+, -, * y /) [ComboBox]
Se introducen los valores de primer y segundo operando complejos.
Se pulsa el botón "=", apareciendo el resultado en los campos de la parte inferior.
MEJORA: Quitar el botón "=" y usar Bindings, de forma que cuando se seleccione una operación en la lista desplegable, se generan los bindings automáticamente.
