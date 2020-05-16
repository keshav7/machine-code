flash sale


# limited inventories, huge number of interested buyers (due to massive price drop/ limited popular inventory)


1. consider 1000 new model sony TVs
2. Discount of 50% for time period of 10 mins.


=> single row

   (product-count) [entity]
   product_type
   count

   (product-item) [Entity]
   id
   status [AVAILABLE, RESERVED, PAID]
   ttl


1. Reads will be served directly through above table.
2. Only when user moves to checkout page
   - aquire lock [transactional flow ACID complaint]
   - decrement count
   - make one of available items as RESERVED and associate ttl with it
   - put this item in cache [redis]
3. run a daemon process every 1 minute which will read the above items in cache
   and take decisions on moving items from RESERVED to AVAILABLE. (notify users (fifo manner) maybe)
4. if the item is checkout out before expiry, remove entry from cache and update status as PAID
