angular.module('html2canvas_proto', ['ngResource', 'ui.bootstrap', 'html2canvas_proto.controllers'])

.factory('ImageFactory', function($resource) {
    return $resource('/images/:id/', {id:'@id'});
})
.factory('ImageAsTextFactory', function($resource) {
    return $resource('/image_text/:id/', {id:'@id'});
});

