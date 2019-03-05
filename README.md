# java-safezoos

Using java-zoos as a starting point (https://github.com/LambdaSchool/java-zoos.git), add security to the application. 

Use (https://github.com/LambdaSchool/java-ourcourses.git) as a model for how to add security.

Security is:
* ROLE ADMIN should be allowed to access /users and /admin
* ROLE User should be allowed to access /animals and /zoos
* ROLE Zoo should be allowed to access /zoos
* ROLE animal should be allowed to access /animals
* ROLE MGR (manager) should be allowed to only access /actuator (stretch goal).
* Everyone should be allowd to access the swagger ui!