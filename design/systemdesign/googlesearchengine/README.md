## Design google type search engine
   - crawl billions of web urls
   - extract information in form of text (limit scope)
   - create snippet , title, words
   - create reverse index wrt to words/ documents
   - serve user queries
   - dedupe documents
   - dedupe urls to prevent repetition.

# url store
   - stores urls to process
   - maintains fifo queue(s) to process urls in controlled manner
   - maintains hashmap to put same domain urls in same queue

# html fetcher
   - get document for a url.
   - puts it in queue to be processed by document extractor

# document extractor
   - talks to doc de-dupe service to process/not the document
   - extracts infor
   - creates snippet, title
   - extracts urls (passes them to url store)
   - dumps above in solr/es

# sharding
   - shard url store processing as consistent-hashing manner
   - redundant nodes for availability
   - basis the url hash

