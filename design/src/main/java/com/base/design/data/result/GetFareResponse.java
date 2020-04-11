package com.base.design.data.result;

import com.base.design.enums.Currency;
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
