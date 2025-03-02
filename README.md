## BEX - Big Exchange Server

#### Features

- Register account to transact 
- View available stocks on exchange
- Get market data via webhook
- See graph for each stock, 
    - including price changes.
    - and trade book.
- Simple leaderboard of all accounts with their activity.
- Allow buy, sell orders

#### Database
In-memory, with a rabbit queue for orders

### Data

```
Tradebook Data
{
ASK_PRICE: 1
BID_PRICE: 0.5
BUY_LIMIT: 10000
LAST_TRADED_PRICE: 1
MAX_PRICE_SHIFT: 1
SELL_LIMIT: 5000
TICKER: "MSFT"
}

#### Products Data
[ PRODUCT_NAME ... ]

#### LeaderBoard Data
[
		"name": "JOE",
		"profit": -10831.8,
		"position": 0,
		"cashBalance": -12674.15,
		"positions": {
			"NFLX": 3000,
			"MSFT": 1000,
			"GOOGL": -4999,
			"AAPL": 900,
			"TSLA": -8375,
			"IBM": 2300,
			"ORCL": -869,
			"AMZN": 703
		}
]

#### Order List
[
	{
		"product": "MSFT",
		"quantity": 4000,
		"price": 1,
		"side": "SELL",
		"executions": [
			{
				"timestamp": "2024-08-09T13:41:31.371",
				"price": 1,
				"quantity": 4000
			}
		],
		"orderID": "ddf78f8a-e295-4d2d-8916-272c46e83b3a",
		"orderType": "LIMIT",
		"cumulatitiveQuantity": 4000,
		"cumulatitivePrice": 1
	}
]
```
