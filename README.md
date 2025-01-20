# Inditex demo

A small demo for an Inditex interview.

The requirements for this demo are stored in the requirements.txt file. 

## Assumptions

 - The demo is written in english, because it's my daily work language and the example data I was given in requirements.txt was in english.
 - The dates given did not contain any timezone information, so I assumed that it was expected of me to work with local time APIs(such as LocalDateTime) and not actual timeline APIs (such as Instant or ZonedDateTime).
 - Given the small scope and time window I had, I assumed a quick and simple architecture would be enough. Possible hexagonal architecture on a Diagram is in the works.
 - I assumed using lombok to reduce boilerplate is OK.
 - Every parameter in the endpoint is a @RequestParam. I thought about using @PathVariables, but it did not feel right with the low amount of entities the application handles.
 - I think the use case could be solved with a slightly more contrived query, but I'm a Java developer applying for a Java developer position, so I solved it using Java.

## Changes

 - Early on, while I was thinking about how to approach the project, I kept changing PRICE_LIST to RATE in my mind. It sounded simpler and more concise, so given that I was allowed to change names in requirements.txt, I did the change.
 - The DateTime formats given in requirements.txt are not ISO formats, so I assumed that format would need to stay as is. Hence, the application parses and returns DateTime-formatted Strings.
 - The H2 DATETIME syntax does not allow the DateTime format presented in requirements.txt, so I had to adapt it because it was asked to pick the more appropriate Type for the column.


## Improvements
 
 - Parameter validation via JSR303 would be nice to have.
 - The architecture is a simple 3 layer with domain rules and names. Good enough for the use case, a Hexagonal modularized one could be better for a bigger project.
 - The use of LocalDateTime makes it so that it's ambiguous when a Rate applies depending on which part of the world you are. I would change that to a DateTime with a ZoneId, Offset, or just a timestamp like Instant.
