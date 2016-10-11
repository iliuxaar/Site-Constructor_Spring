var heh = angular.module('create', []);

heh.component('create', {
    templateUrl: '/templates/create.template.html',
    controller: function ($http, $scope, $window) {

        $scope.name = null;

        $scope.submit = function() {
            console.log($scope.name);
            $http.post('/site/save',$scope.name).success(function() {
                $window.location.href = '#/userpage';
            }).error(function() {
                console.log("Fail");
            });
        };
    }
});