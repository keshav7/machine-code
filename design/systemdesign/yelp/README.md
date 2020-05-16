## Design yelp
   or nearby places search app. Given user current location find nearby
   attr/activitie events restaurant other places (salon etc.)

## low scale solution
  - Store all inventories (say up to 100k) in this model
    `{
    name
    type
    lat (double)
    lng (double)
    }`
  - crud around above entity
  - /search requests can be powered by performing range query on (xi - xj), (yi, yj)
  - finally taking intersection of above results
  - lat/lng are indexed in db

  - cons
    - db indexes on float values may not be as efficient as string indexes
    - at large scale (1 billion inventories), performing range queries is not good solution
    - huge possible results to take intersection from possible, degrading query performance

## high scale alternative

  - consider using spatial Dbs
  - think of whole planet as being divided into cells of lets say 1*1 mile
  - we can have close to 5 million cells to cover whole planet
  - associate cell_id with each location and define index on it
  - there will be less results set as will do in query (c1, c2 ie cell1, cell2 etc.)
  - in above entity, instead of lat/lng story some other identifier like cell_id.

# steps:
1.
  - imagine a grid app with app cluster and db cluster (sql)
  - it maintains 3 entities
    - cells
      `{id, lat,  lng}`
    - cell-count
      `{cell_id, count}`
    - location
      `{location_id, cell_id}`

2. for input request (given current location return list of nearby locations)
   perform below steps
   - get relevant cells.
   - for each of those cells perform in query on location entity
   - enrich data (location details) and return results.
   - if cell_count increases  beyond a threshold,
     break it into 4 cells and redistribute all entities

3. scope of sharding?
   - can shard basis the location id
   - aggregate service can maintain common `cells` and `cell_count`
   - given the cell_ids an aggregate results from all shards and return results.
   - can cache results given the cell_id (10 days)
     - invalidate if cell_id is broken down.


## other points of discussion
   - location details server
     `{id, name, type, audit, lat, lng, type, description, media}`
   - reviews/ratings server
   - reactions server
   - comments server
   - ranking server
   - aggregate server collects all results and serves results in paginated manner
     - can also maintain read aside cache for same