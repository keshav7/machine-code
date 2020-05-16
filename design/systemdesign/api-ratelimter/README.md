## API rate limiter
   limit requests by same user above a threshold. Eg allow 10 requests per user in 30 seconds time.


# App cluster

# rate limit cluster
  - (app - optional)
  - storage (rate limit data)
  - `key : userid, value : [{time_stamp}]` -- sorted list
  - kind of rolling window design
  - for a new request
    - if no object found
      - create a new entry
    - remove all old entries within threshold
    - if first_entry < threshold & count == threshold
      - reject request
    - else add on top


