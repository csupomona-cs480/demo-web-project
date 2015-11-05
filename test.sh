#!/bin/sh

#  test.sh
#  
#
#  Created by David Mongiello on 11/4/15.
#
#Trying to get jenkins to work
"scripts": {
"ci-test": "istanbul cover tape \"test/*-test.js\" > test.tap && istanbul report clover"
}
