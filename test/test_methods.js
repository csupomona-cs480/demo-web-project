var test = require('tape')
var request = require('superagent');
var expect = require('expect.js');

test('Suite one', function(t){
     
         it (function(done){
             request.post('localhost:3000').end(
                                                function(res){
                                                expect(res).to.exist;
                                                
                                                done();
                                                });
             });
         });