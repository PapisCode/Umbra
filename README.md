# Umbra

Final Project for Web Application Development - CPAN-228-RNA

## Team Contributions

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
