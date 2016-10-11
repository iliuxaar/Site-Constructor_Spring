var heh = angular.module('user', ['ngRoute']);

heh.component('user', {
    templateUrl: '/templates/user.template.html',
    controller: function ($scope,$http) {
        $http.get('http://localhost:8080/site/get_user_data').success(function (data) {
            $scope.site = data;
        });

        $scope.removeItem = function removeItem(row) {
            var index = $scope.site.indexOf(row);
            var id = $scope.site[index].id;
            $http.get('/site/'+id+'/delete').success(function () {
                if (index !== -1) {
                    console.log("all good")
                    $scope.site.splice(index, 1);
                }
            });
        }
    }});