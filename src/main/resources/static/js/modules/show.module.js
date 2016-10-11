var heh = angular.module('show', []);

heh.component('show', {
    templateUrl: '/templates/show.template.html',
    controller: function ($scope,$http,$routeParams,$window) {

        var id = $routeParams.siteId;
        var arr;
        $scope.content;
        $http.get('/site/pages/'+id).success(function (data) {
            $scope.pages = data;
            $scope.sitenam = $scope.pages[0].site.siteName;
            $scope.content = $scope.pages[0].content;
            arr = data;
            console.log(arr);
        });

        $scope.setcontent = function(idcon) {

            arr.forEach(function (item, i, arr) {
                if(item.id == idcon){
                    $scope.content = item.content;
                }
            });
        };
    }
});
