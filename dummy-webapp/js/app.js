angular.module('screenshot', ['ngResource', 'ui.bootstrap', 'screenshot.controllers'])

    .factory('ImageFactory', function($resource) {
        return $resource('/screenshot/api/Screenshot/:id/', {id:'@id'});
    })
    .factory('UserFactory', function($resource) {
        return $resource('/api/me/');
    });

