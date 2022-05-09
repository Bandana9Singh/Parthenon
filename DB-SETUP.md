### Pre-requisites
- mongodb
- clone https://github.com/mw60680/MongoLoader

### Steps
1. Get mongodb server running
2. Create database gaia in mongodb with collections editions, authors, works, ratings
3. Download required dumps from open library and execute the MongoLoader app
4. Once data is loaded to respective collections, create the following indexes
    a. Editions collection
        - compound index for full text search
          ```
          use gaia
          db.editions.createIndex({title: "text", subtitle: "text"}, {language_override: "dummy"})
          ```
    b. Authors collection
        - name index  
          {field: name, type: 1}
          custom collation - {locale: english, strength: 2}
