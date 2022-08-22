# Installation guide


## Backend
Change on application.properties the database url, username, password to connect to db production
Run `mvn clean install` on command pront to create a war on the project. This war can be added to a java container to deploy or add to a tomcat server.

## FrontEnd
Change the url value on environment.prod.ts to connect correctly to the backend on production environment. 
Run `ng build --prod` to generate the js,css and html files. You can add this no a nginx or apache server to deploy. or craete a docker container withe nginx or apache to deploy.

