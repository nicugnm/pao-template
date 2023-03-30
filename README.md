# E-ticketing System


### Class Hierarchy
- Abstract classes:
- - Event => Concrete classes: CulturalEvent and SportsEvent
- - Location => Concrete classes: CulturalLocation and SportsLocation

- Concrete classes:
- - Client
- - CardInformation
- - MailInformation
- - Ticket

- Enum classes (used to define type of fields for other concrete classes):
- - CulturalEventType
- - SportsEventType
- - CulturalLocationType
- - SportsLocationType
- - TicketType

### Available functionalities
- CRUD operations for MailInformation
- CRUD operations for CulturalEvent
- CRUD operations for Location
- Sorting Locations in lexicographic order
- Sorting Clients by number of tickets they have purchased
- Sorting Events by StartDate
- Filter SportsEvents by their location-type
- Set DeleteTime for Events that have already started
- Get number of tickets for an event, grouped by ticket-category
- Functionality for "buying" and "selling" tickets for an event