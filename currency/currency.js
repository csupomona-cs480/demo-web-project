/**
 * This file is part of the JS Money library
 *
 * Copyright (c) 2014 David Kalosi
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

var currencies = {
    "USD": {
        "symbol": "$",
        "name": "US Dollar",
        "symbol_native": "$",
        "decimal_digits": 2,
        "rounding": 0,
        "code": "USD",
        "name_plural": "US dollars"
    },
// Party bucks are for bonis currency only.
    "PYB": {
        "symbol": "YR",
        "name": "Party Buck",
        "symbol_native": "$",
        "decimal_digits": 0,
        "rounding": 0,
        "code": "PYB",
        "name_plural": "Party Bucks"
    },
// Used to caclulate the rating that somebody gives out.
    "RAT": {
        "symbol": "R",
        "name": "Ratings",
        "symbol_native": "R",
        "decimal_digits": 2,
        "rounding": 0,
        "code": "RAT",
        "name_plural": "Ratings"
    }
    };

Object.keys(currencies).forEach(function (currency) {
                                module.exports[currency] = currencies[currency];
});
