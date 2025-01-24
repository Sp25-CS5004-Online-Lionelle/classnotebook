# Module 03 Live Session

For the context for this session, we are going to build classes for a media app - that handles

* Digital books
* Audio Books
* Music Files 

(for now). 

## Before you start coding

Ask yourself, what is in common with my "nouns" or objects in this system



**media** 
 - yearCreated - field
 - creator 
 - title 
 - length??
 - fileSize
 - file (the actual file)
 - price (if we are selling it)
 - ratingAvg
 - ratingPersonal
 - downloads
 - encodingType
 - +getYearCreate() // getters and setters for all of them
 - +setRating(int value)
 - +getPrice() 
 - genre
 - +getGenre()




**audioMedia** (extends media)
- isrc (audio / music only)
- lengthInTime


**books** (so could be media or audio), extends media
- pages
- chapters


**audioBook** - would need both books, audioMedia


> [!IMPORTANT]
> For our example - getPrice() varies based on TYPE of media - just for example. 

Price Variation
* If Book - 1.99
* if Music - 99
* if audiobook - 5.99