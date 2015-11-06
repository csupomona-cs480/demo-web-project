var test = require('tape')
var request = require('superagent');
var expect = require('expect.js');

test('Suite one', function(t){
     t.plan(1);
     
         setTimeout (function(){
             request.post('localhost:8080').end(
                                                function(res){
                                                expect(res).to.exist;
                                                
                                                done();
                                                });
             }, 10);
         });