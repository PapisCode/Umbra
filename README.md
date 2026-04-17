# Umbra

Final Project for Web Application Development - CPAN-228-RNA

## Team Contributions / Phase 1

### Gabriel Hernandez

I was mainly responsible for setting up, organizing, fixing, and styling the front-end structure of the project for Deliverable 1.

My work included:

- setting up and correcting the Spring Boot project structure so the application could run properly with Maven
- organizing the folder structure under `src/main/java` and `src/main/resources` so everything matched Spring Boot conventions
- fixing package paths and moving files into the correct locations such as:
  - `controller`
  - `entity`
  - `form`
  - `repository`
  - `service`
  - `templates`
  - `templates/fragments`
  - `static/css`
- helping make sure the `mvnw` command worked properly and that the application actually started on localhost without crashing
- fixing project structure issues that were causing routing, controller, and template loading problems
- helping connect the application to the H2 database using Spring Data JPA
- updating `application.properties` so the database, Thymeleaf, and SQL initialization worked correctly
- fixing and integrating `data.sql` so sample data loads on startup
- working on the front-end page setup and user flow for Deliverable 1
- building and styling the main visible pages:
  - Home page (`/`)
  - About page (`/about`)
  - Brands page (`/brands`)
  - Items page (`/items`)
  - Add Item form page (`/items/new`)
- creating and fixing shared Thymeleaf fragments for:
  - navbar
  - footer
- fixing Thymeleaf fragment/template parsing issues so the pages could render properly
- styling the project with Bootstrap and custom CSS to make the application look cleaner and more professional
- improving layout, spacing, buttons, tables, cards, and form styling across the pages
- implementing the item catalog page layout with:
  - search
  - filtering
  - sorting
  - pagination UI
- implementing the add item form UI and validation message display
- helping make sure the item workflow was working from form submission to saved record display
- testing the application pages and fixing issues that were preventing routes and templates from loading correctly
- pushing and maintaining my work through my own feature branch:
  - `feature/gabriel-ui-items`

Overall, my main contribution was getting the project into a clean working state for Deliverable 1 and building the front-end/UI side of the application so the app could be demoed properly with working pages, seeded data, and a consistent design.

### Oluwaseun

- tested the app’s functionality on both the backend and UI side
- checked the form flow and server-side validation
- fixed UI issues related to floating footers
- did this work on the branch:
  - `feature/oluwaseun-updates`
  
### Andre Tolentino

- tested the item form workflow and made sure item submission works properly
- verified server-side validation, redirect behavior, and that new items appear correctly in the item list
- worked on the database-related item save flow and helped confirm item records persist correctly
- added and checked pagination behavior for the item list
- did this work on the branch:
  - `feature/andre-tolentino`
## Branch Strategy

Each team member worked on their own feature branch before merging changes into the main branch. This was done to keep work organized, avoid conflicts, and clearly show individual contributions.

______________________________________________________________________________________________________________________________

## Team Contributions / Phase 2

### Gabriel Hernandez

For Phase 2, I was responsible for implementing the full security and user management system using Spring Security, as well as integrating it with the existing application.

My contributions included:

- adding Spring Security dependency and configuring the project for authentication and authorization
- creating the Role enum with:
1. ADMIN
2. STAFF
3. CUSTOMER
- creating the User entity and implementing UserDetails for Spring Security compatibility
- creating the UserRepository to load users from the database
- creating CustomUserDetailsService to handle user authentication logic
- configuring security using SecurityFilterChain instead of deprecated configurations
- defining public and protected routes:
1. public: /, /about, /brands, /items, /login, /register
2. protected: /items/new, /items/save
3. admin-only: /admin
- implementing role-based access control using:
1. hasRole("ADMIN")
2. hasAnyRole("STAFF", "ADMIN")
- building a custom login page:
1. styled with Bootstrap
2. displays error messages for invalid credentials
- building a custom registration page:
1. form validation using annotations
2. password confirmation check
3. username uniqueness validation
- implementing password encoding using BCrypt before saving users
- creating a DataInitializer to seed test users with encoded passwords:
1. admin / admin123
2. staff / staff123
3. customer / customer123
- creating the AuthController to handle login and registration routes
- creating the AdminController to provide an admin-only dashboard page
- building the admin dashboard page:
1. displays users
2. displays items
3. styled as an administrative interface
- protecting routes so:
1. unauthenticated users are redirected to login
2. unauthorized users receive forbidden access
- updating the navbar to dynamically show:
1. login/register links when logged out
2. username and logout when logged in
3. admin link only for ADMIN users
- restricting UI elements using Thymeleaf Security:
1. hiding "Add Item" button for non-staff/non-admin users
- fixing authentication redirect loops by separating login page and processing URL
- testing all role-based scenarios:
1. admin full access
2. staff limited access
3. customer restricted access
- verifying password encryption using the H2 database console
- recording the Deliverable 2 demo video demonstrating:
1. public access
2. login and logout
3. role-based restrictions
4. registration flow
5. encoded passwords in database
- managing all Phase 2 work through my feature branch:
- feature/gabriel-security
- merging Phase 2 changes into the main branch after completion
_______________________________________________________________________________________________________________________________________

## Team Contributions / Phase 3

### Gabriel Hernandez

For Phase 3, I was responsible for deploying the application in a production-like environment using Docker and integrating a MySQL database.

My contributions included:

1. implementing full Docker support for the application
2. creating a Dockerfile to package the Spring Boot application into a container
3. creating a docker-compose.yml file to orchestrate:
    - the Spring Boot application container
    - the MySQL database container
4. configuring the application to support multiple environments using Spring profiles:
  1. dev profile
    - uses H2 in-memory database
    - used for local development and testing
  2. qa profile
    - uses MySQL database running in Docker
    - simulates a production-like environment
5. restructuring configuration files:
  1. moved database settings into:
    - application-dev.properties
    - application-qa.properties
    - simplified base application.properties
6. adding MySQL driver dependency to the project
7. configuring database connection for Docker environment:
    - host: mysql
    - database: umbra_db
    - user: umbra_user
8. resolving Docker and environment issues including:
    - container startup failures
    - database connection issues
    - duplicate data errors caused by persistent volumes
9. fixing SQL initialization issues by:
    - adjusting Hibernate settings for clean schema creation
    - ensuring data.sql runs correctly with MySQL
10. verifying that:
    - application runs fully inside Docker
    - MySQL container is connected and working
    - seeded data (brands, categories, items) loads correctly
    - user authentication system continues to function with MySQL
11. testing full application flow inside Docker:
    - home page
    - item catalog
    - login and registration
    - role-based access
12. confirming the application is accessible via:
    - http://localhost:8080
13. managing all Phase 3 work through my feature branch:
    - feature/phase3-deployment
14. merging Phase 3 changes into the main branch after completion





