angular.module('html2canvas_proto.controllers', [])

.controller('TestCtrl', function($scope, ImageAsTextFactory) {

//        $scope.init = function() {
//            console.log('initialized controller!');
//
//            console.log('attempting to screenshot!');
//
//            $document.ready(function() {
//                html2canvas(document.body, {
//                    onrendered: function(canvas) {
//                        console.log("Got response!");
//                        $scope.canvaselement = canvas.toDataURL();
//                        console.log(canvas);
//                        document.body.appendChild(canvas);
//                        console.log("Stuff:");
//                        console.log(canvas.toDataURL("image/png"));
//                    }
//                });
//            });
//        };

        $scope.store_image = function() {
            html2canvas(document.body, {
                onrendered: function(canvas) {
                    ImageAsTextFactory.save({image: canvas.toDataURL("image/png")}, function(response){
                        console.log('Saved image!');
                    });
                }
            });
        };

//        $scope.init();
    });
