package com.base.cab_booking.data.result;

import com.base.cab_booking.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFareResponse {

  Long price;
  Currency currency;

}
