# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  21/22)
Autor/a: David Vargas Muñiz   uvus:davvarmun

El proyecto consiste en programar una serie de tipos siguiendo un diseño determinado.


## Estructura de las carpetas del proyecto

* **src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.clinico**: Paquete que contiene los tipos Paciente, PacienteEstudio, Persona y TipoResidencia(enumerado) del proyecto.
  * **fp.farmaceutico**: Paquete que contiene las clases FactoriaMedicamentos, Medicamento y el enumerado TipoMedicamento del proyecto.
  * **fp.farmaceutico.test**: Paquete que contiene la clase de test TestFactoriaMedicamentos
  * **fp.utiles**:  Paquete que contiene las clases de utilidad.
  * **fp.vacunas**:  Paquete que contiene el tipo Vacunacion.
* **/data**: Contiene el dataset o datasets del proyecto (de momento no se utiliza)
    * **\<dataset1.csv\>**: Añade una descripción genérica del dataset.
    * **\<dataset2.csv\>**: Añade una descripción del resto de datasets que puedas tener.
    
## Estructura del *dataset(NO UTILIZADO)* 

Aquí debes describir la estructura del dataset explicando qué representan los datos que contiene y la descripción de cada una de las columnas. Incluye también la URL del dataset original.

El dataset está compuesto por \<N\> columnas, con la siguiente descripción:

* **\<columna 1>**: de tipo \<tipo\>, representa....
* **\<columna 2>**: de tipo \<tipo\>, representa....
....

## Tipos implementados

Se han implementado los siguientes tipos.

### Persona
Tipo programado como record.

**Propiedades**:

- nombre, de tipo String.
- apellidos, de tipo String.
- dni, de tipo String.
- fechaNacimiento, de tipo LocalDate.
- edad, de tipo Integer. (Derivada a partir de la fecha de nacimiento) 

**Constructores**: 

- Utiliza el constructor del record.

**Restricciones**:
 
- R1: La fecha de nacimiento debe ser anterior a la fecha actual.
- R2: El dni debe ser una cadena con ocho dígitos y seguidos de una letra. 

**Criterio de igualdad**: por defecto asociado al record.

**Orden natural**: por dni.

**Otras operaciones**:
 
-	Boolean sonDigitos: Comprueba que los caracteres de la cadena son dígitos.


### Paciente
Tipo programado como record.

**Propiedades**:

- persona, de tipo Persona.
- códigoDeIngreso, de tipo String.
- fechaHoraIngreso, de tipo LocalDateTime.
- fechaIngreso, de tipo LocalDate. (Derivada a partir de la fecha y hora de ingreso)
- horaIngreso, de tipo String. (Derivada a partir de la fecha y hora de ingreso). 

**Constructores**: 

Utiliza el constructor del record.

**Restricciones**:
 
- R1: La fecha y hora de ingreso debe ser anterior o igual a la fecha actual. 

**Criterio de igualdad**: por defecto asociado al record. 


### PacienteEstudio
Tipo programado como record.

**Propiedades**:

- id, de tipo String.
- genero, de tipo String.
- edad, de tipo Double.
- hipertensión, de tipo Boolean.
- enfermedad del corazón, de tipo Boolean.
- tipoDeResidencia, enumerado TipoResidencia, cuyos valores son rural o urbana.
- nivelMedioGlucosa, de tipo Double.
- factorRiesgo, de tipo Boolean. (Derivada, si tiene hipertensión y más de 40 años se
considerará que tiene factor de riesgo).  

**Constructores**: 

- Utiliza el constructor del record.

**Restricciones**:
 
- R1: La edad tiene que ser mayor o igual que cero y menor o igual que 130.
- R2: El nivel medio de glucosa tiene que ser mayor o igual que cero.

**Criterio de igualdad**: por defecto asociado al record.

**Criterio de orden**:  según la edad y el id.

**Otras operaciones**:
 
- Método static parse: recibe una cadena con un formato especificado y y devuelve un objeto del tipo. Ejemplo de cadena: “6306;Male;80;false;false;URBANA;83.84”.
- Método main: para comprobar el correcto funcionamiento del método parse.


### Vacunacion
Tipo programado como record.

**Propiedades**:

- fecha, de tipo LocalDate.
- comunidad, de tipo String.
- pfizer, de tipo Integer.
- moderna, de tipo Integer.
- astrazeneca, de tipo Integer.
- janssen de tipo Integer.
- númeroPersonas, de tipo Integer.
- númeroTotal, de tipo Integer. (Derivada, siendo la suma de dosis de Pfizer, moderna,
astrazeneca y janssen). 
 

**Constructores**: 

- Utiliza el constructor del record.

**Restricciones**:
 
- R1: La fecha de debe ser posterior al 01/02/2021.

**Criterio de igualdad**: por defecto asociado al record.

**Orden natural**: por comunidad y en caso de igualdad por fecha.

**Otras operaciones**:
 
- Método static parse: recibe una cadena con un formato específico y devuelve un objeto del tipo. Ejemplo de cadena: “04/01/2021;Andalucía;140295;0;0;0;0”.
- Método main: para comprobar el correcto funcionamiento del método parse.


### Medicamento
Tipo programado como record.

**Propiedades**:

- nombreMedicamento, de tipo String, observable.
- tipoDeMedicamento, enumerado de tipo TipoMedicamento, observable. Los valores
del enumerado son anatómico, químico y terapéutico.
- códigoEnfermedad, de tipo String, observable.
- farmacéutica, de tipo String, observable.
- puntación, de tipo Double, observable.
- índiceSomático, de tipo Integer, observable.
- fechaCatálogo, de tipo LocalDate, observable y modificable.
- tratarEnfermedad, de tipo Boolean. (Derivada, siendo cierta si el código de la
enfermedad coincide con un parámetro de tipo cadena que reciben como argumento
la propiedad). 
 

**Constructores**: 

- Utiliza el constructor de la clase.

**Restricciones**:
 
- R1: La puntación tiene que ser mayor estricta que cero.
- R2: El índice somático tiene que ser mayor o igual que 1000.
- R3: La fecha de catálogo tiene que ser posterior al 01/01/2015.

**Criterio de igualdad**:  por nombre del medicamento y farmacéutica.

**Orden natural**: por nombre del medicamento y en caso de igualdad por la farmacéutica.





#### Tipos auxiliares
Se han añadido los siguientes tipos auxiliares: TipoResidencia(enumerado), TipoMedicamento(enumerado).
Se ha programado una clase de nombre FactoriaMedicamentos que incluya, de momento, un método static de nombre FactoriaMedicamentos parse, que recibe una cadena con un formato específico y devuelve un objeto de tipo Medicamento.
Ejemplo:
“efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019”.
(Siendo la información del nombre del medicamento, el tipo de medicamento, el
codigo de la enfermedad, la farmaceutica, la puntuacion, el índice somatico, y la fecha
de catalogo)
Se ha implementado una clase de nombre TestFactoriaMedicamentos en un paquete de nombre fp.farmaceutico.test y compruebe el correcto funcionamiento del método anterior. 

### Factoría
Se han utilizado diversos métodos de factoría según cada tipo.

- Tipo Persona:
  	- Método static of: recibe nombre, apellidos, dni y fecha de nacimiento y devuelve una persona.
  	
- Tipo Paciente:
	- Método static of: recibe nombre, apellidos, dni, fecha de nacimiento, código y fecha y hora de ingreso y devuelve un paciente.
	- Método static of: recibe un objeto persona, un código y una fecha y hora de ingreso y devuelve un paciente.
	
- Tipo PacienteEstudio:
	- Método static of: recibe valores para cada propiedad básica y devuelve un objeto del tipo.
	
- Tipo Vacunacion:
	- Método static of: recibe valores para cada propiedad básica y devuelve un objeto del tipo.
	
