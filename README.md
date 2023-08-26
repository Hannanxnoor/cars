This repo must include your code, and VERY IMPORTANT a README.md file with your reflections to how your solution covered the learning goals given for the matching lecture:
The idea with, and reasons for why to use, a ORM-mapper
- 

 ORM-mapper (Object.Relational Mapping) kort så oversætter den objekter i programmer til database til databasetabeller.
 Dvs. her behøves ikke at skrive direkte sql forespørgsler i vores databasase oghave mere fokus på objektorienteret programmering.

The meaning of the terms JPA, Hibernate and Spring Data JPA and how they are connected
- 
JPA står for (Java Persistence API) og definere hvordan java-objekter bliver gemt og hentet fra en database uden skulle skrive en masse sql forespørgsler. 

Hibernate implemetere JPA standarden og gør det muligt for objekter at blive gemt i databasen. 

Spring Data JPA bygger oven på JPA og Hibernate. Fx  tilføjer funktioner som gør det nemmer at arbejde med CRUD på databaser uden at skrive meget kode. 
   
How to create simple Java entities and map them to a database via the Spring Data API
-
-   Oprette min entity klasse og give den en @entity annotation definere entitieter og kolonner til databasen.
-	Oprette en repository interface der extends JpaRepository
-	Oprette en forbindelse mellem java og database
-	Run min springboot application. 

How to control the mapping between individual fields in an Entity class and their matching columns in the database
- 
Jeg brugte denne annotation: @Column(name = "kolonne_navn")
Den giver mig muligheden for at definere helt explicit et kolonnes navn i databasen der svar til det felt i min entitets klasse. 

How to auto generate IDs, and how to ensure we are using  a specific database's preferred way of doing it (Auto Increment in our case for  MySQL)
- 
Brugte denne annotation: @GeneratedValue(strategy = GenerationType.IDENTITY)
Sammen med @Id annotationen som gør at der bliver brugt mySQL indbygget auto increment funktionalitet til at generer unikke id for hver tilføjelse til tabellen.
 


