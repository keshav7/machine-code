## Requirements
1. system maintains nearby available cabs wrt given location
2. match demand (cab request from user) to supply (cabs availability) nearby
3. Associate price.
4. misc - Analytical etc.


## Main components:

# user service
1. maintains information about users/drivers. like name, audit info, account info etc.
2. purpose is can provide unique identifier for users/drivers.

# driver location service (grid service)
1. requirements
   - ingest driver location pings (cming every 5 seconds)
     - update driver location against relevant grid id.
   - get list of drivers nearby given the location in request efficiently.
     - can store in this form
      - {driver_id, grid_id}
      - spits out grid id for given lat/lng
      - can also use s2 library for same
2. storage
   - shard storage using consistent hashing and basis driver id.
   - for a grid id need to call parallelShardProcessor to aggregate results and return results.


#trip service
   - creates trip with following model
     - {id, request_id, from, to, status, driver_id, vehicle_id}

# orchestrator service
   - talks to multiple services
     - eg. create new request
     - fetch possible drivers
     - rank them
     - notify them
     - absorbs events from driver app
     - talks to trip service to create trip
     - absorbs multiple events from user/driver to update trip
     - send relevant notifications.

