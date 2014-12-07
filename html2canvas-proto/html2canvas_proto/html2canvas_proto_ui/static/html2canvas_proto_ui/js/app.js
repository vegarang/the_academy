angular.module('html2canvas_proto', ['ngResource', 'ui.bootstrap', 'html2canvas_proto.controllers'])

    .factory('ImageFactory', function($resource) {
        return $resource('/api/images/:id/', {id:'@id'});
    })
    .factory('ImageAsTextFactory', function($resource) {
        return $resource('/api/image_text/:id/', {id:'@id'});
    })
    .factory('UserFactory', function($resource) {
        return $resource('/api/me/1', {});
    });

