angular.module('screenshot', ['ngResource', 'ui.bootstrap', 'screenshot.controllers'])

    .factory('ImageFactory', function($resource) {
        return $resource(
            '/screenshot/api/Screenshot/:id/',
            {id:'@id'}, {
                all: {method:'POST', isArray: true}
            }
        );
    })
    .factory('UserFactory', function($resource) {
        return $resource('/dhis/api/me/');
    });

