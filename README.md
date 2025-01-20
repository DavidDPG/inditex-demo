# Inditex demo

A small demo for an Inditex interview.

The requirements for this demo are stored in the requirements/requirements.txt file. 

The database is pre-populated at startup using liquibase. The master changelog is src/resources/db.changelog/db.changelog-master.yaml

## Assumptions

 - The demo is written in english, because it's my daily work language and the example data columns I was given in requirements.txt was in english.
 - The dates given did not contain any timezone information, so I assumed that it was expected of me to work with local time APIs(such as LocalDateTime) and not actual timeline APIs (such as Instant or ZonedDateTime).
 - Given the small scope and time window I had, I assumed a quick and simple architecture would be enough. Possible hexagonal architecture on a Diagram is in the works.
 - Decided to use the Lombok library to reduce boilerplate.
 - Every parameter in the endpoint is a @RequestParam. Normally I would use PathVariables if Brand and Product entities have their own endpoints and logic, but given the simplicity of the given dataset I opted for @RequestParam.
 - I believe this specific use case could be solved with a slightly more contrived query, but given that this challenge is meant to analyze my Java development skills I opted to develop the use case logic using Java.

## Changes

 - Early on, while I was thinking about how to approach the project, I kept changing PRICE_LIST to RATE in my mind. It sounded simpler and more concise, so given that I was allowed to change names in requirements.txt, I went through with it.
 - The DateTime formats given in requirements.txt are not ISO formats, so I assumed that format would need to stay as is. Hence, the application parses and returns DateTime-formatted Strings.
 - The H2 DATETIME syntax does not allow the DateTime format presented in requirements.txt, so I opted to adapt the input data for it to fit the syntax. I went through with it instead of using a different data type because it was stated that I should pick the most appropriate data types.
 - I added some more test cases that came to my mind while analyzing the use case and developing the solution.

## Improvements
 
 - Parameter validation via JSR303 would be nice to have.
 - The architecture is a simple 3 layer with domain rules and names. Good enough for the use case, a Hexagonal modularized one could be better for a bigger project.
 - The use of LocalDateTime makes it so that it's ambiguous when a Rate applies depending on which part of the world you are. I would change that to a DateTime with a ZoneId, Offset, or just a timestamp like Instant.
