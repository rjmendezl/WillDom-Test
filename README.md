# **WillDom-Test**

### Credit Card validation using backend and frontend

## Requirements

*In order to run this project, you must have installed the following:*
- Docker
- Java
- JDK
- npm

## Steps to run the project

1. Open the folder *database* and open a new terminal as an administraron, then run **docker-compose up** to create the postgres image using docker

2. Open the folder *CreditCardValidation*, you can use any IDE but you can do it easier on IntelliJ and simply click on the _Run_ icon.

3. Once the project is running you can use any DataBase explorer to see that the DB was automatically created and it's ready to save information

4. Open the folder CreditCardUI, you can use VSCode

5. Open a Terminal and run **npm install** 

6. After that, run **ng serve** 

    - **Important!** If you get an error related to SweetAlert is due to a version conflict, you can solve it by going to `..\node_modules\sweetalert\typings\sweetalert.d.ts` and delete the line 4, after that, the project should be running without any issue

7. Navigate to `http://localhost:4200/` and try the app yourself!