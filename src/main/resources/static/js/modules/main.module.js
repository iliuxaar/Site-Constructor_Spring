var mainModule = angular.module('main', []);

mainModule.component('main', {
    templateUrl: '/templates/main.template.html',
    controller: function ($scope,$http) {
        $scope.site = [];
        $http.get('http://localhost:8080/site/get_all').success(function (data) {
            $scope.site = data;
        });
    }});


