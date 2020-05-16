book-my-show


- design book-my-show (design scalable movie booking app)

## Entities
1. cinema
2. cinema-seat
3. show
4. booking
5. booking-seat (reservation)
6. user/city/state
7. movie


## Main Entity details

1. cinema-seat

`
{
id
show_id
name
type
}
`

2. show

`
{
id
cinema_id
movie_id
start_time
}
`

3. booking

`
{
id
user_id
created_at,
show_id
ttl
status [created/expired/reserved]

}`


4. reservation

`
{
id
booking_id
cinema_seat_id
}`


## APIs
1. admin APIs
   - cinema CRUD
   - movie CRUD
   - show CRUD

2. /show/search
   - paginated apis against pojo like moviename, city, genre etc.

3. /seat_availability [for a show]
   - intersection of cinema_seats and reservation entity

4. /book-seats
   - @Transactional [ACID complaint]
   - make entry in booking and reservation tables
   - put entry in cache
     - data structure :  key : show-id, value : [booking-id, ttl]
     - daemon process which runs every 1 minute to identify aged bookings and to free reservation (notify users maybe in fifo manner)



 ## main system compenents
 1. available app cluster behind elb
 2. data for above entities in sql like store (master-slave)
 3. redis for cache requirement as above
 4. quartz for daemon jobs



 









