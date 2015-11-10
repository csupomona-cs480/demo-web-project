

var request = require('supertest');
//var express = require('express');

require = require('really-need');

describe('loading express', function () {
         var server;
         beforeEach(function () {
                    server = require('../server', { bustCache: true })(8081);
                    });
         afterEach(function (done) {
                   server.server.close(done);
                   });
         it('responds to slash', function testSlash(done) {
            request(server)
            .get('/')
            .expect(200, done);
            });
         it('404 everything else', function testPath(done) {
            console.log('test 404')
            request(server)
            .get('/foo/bar')
            .expect(404, done);
            });
         });
         
