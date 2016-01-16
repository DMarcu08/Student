var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', function($scope) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';

}]);

app.controller('PersoanaController', ['$scope', '$http', function($scope,$http) {
	
  var url = 'http://localhost:8080/persoana/';
  $scope.edit = false;
  $scope.openP = false; 
  
  $scope.show = show;
  $scope.persoane = {};
  $scope.editPerson = {};
  $scope.openPerson = {};
  $scope.getPerson = {};
  $scope.editPerson.id = undefined;
  $scope.editPerson.name = undefined;
  $scope.updatePerson = updatePerson;
  
  
  $http.get('http://localhost:8080/persoana/').then(function(response){
	  
	  $scope.persoane = response.data;
	  console.log('persoane:', $scope.persoane);
  });
  
  $scope.deletePersoana = function(id) {
		 $http.delete('http://localhost:8080/persoana/' + id).then( function(response){
			console.log('delete:', response.data);
			 $http.get('http://localhost:8080/persoana/').then(function(response){
	  
		     $scope.persoane = response.data;
			 console.log('persoane:', $scope.persoane);
			});
		});
  }
  
    $scope.setUpdatePerson = function(person) {
        $scope.editPerson = person;
		show('edit');
    };

	
	$scope.getPerson = function getPerson(id){
		$http.get(url + id).then( function (response){
			$scope.openPerson = response.data;
		});
		
		show('openP');
	}
	
    function updatePerson() {
		console.log('persoana trimisa ',$scope.editPersoane);
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editPerson
        }).then(function successCallback(response) {
            $scope.editPerson = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editPerson = {};
            console.log(response);
        });
    };
	
	$scope.savePerson = function(persoana){
	    persoana.id = parseInt(persoana.id);
        console.log(persoana.id);
        $http({
            method: 'POST',
            url: url,
            data: persoana
        }).then(function successCallback(response) {
            console.log(response);
            $scope.persoane.push(persoana);
        }, function errorCallback(response) {
            console.log(response);
        });
	};
	
	
	function show(type){
		if(type == 'edit'){
			$scope.edit = !$scope.edit;
		}
		if(type == 'openP') {
			$scope.openP = !$scope.openP;
		}
	}
}]);


app.controller('SportController', ['$scope', '$http', function($scope,$http) {
  var url = 'http://localhost:8080/sport/';
  $scope.edit = false;
  $scope.openP = false; 
  
  $scope.show = show;
  $scope.sporturi = {};
  $scope.editSport = {};
  $scope.openSport = {};
  $scope.getSport = {};
  $scope.editSport.id = undefined;
  $scope.editSport.name = undefined;
  $scope.updateSport = updateSport;
  
  
  $http.get('http://localhost:8080/sport/').then(function(response){
	  
	  $scope.sporturi = response.data;
	  console.log('sporturi:', $scope.sporturi);
  });
  
  $scope.deleteSport = function(id) {
		 $http.delete('http://localhost:8080/sport/' + id).then( function(response){
			console.log('delete:', response.data);
			 $http.get('http://localhost:8080/sport/').then(function(response){
	  
		     $scope.sporturi = response.data;
			 console.log('sporturi:', $scope.sporturi);
			});
		});
  }
  
    $scope.setUpdateSport = function(sport) {
        $scope.editSport = sport;
		show('edit');
    };

	
	$scope.getSport = function getSport(id){
		$http.get(url + id).then( function (response){
			$scope.openSport = response.data;
		});
		
		show('openP');
	}
	
    function updateSport() {
		console.log('sport trimis ',$scope.editSport);
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editSport
        }).then(function successCallback(response) {
            $scope.editSport = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editSport = {};
            console.log(response);
        });
    };
	
	$scope.saveSport = function(sport){
	    sport.id = parseInt(sport.id);
        console.log(sport.id);
        $http({
            method: 'POST',
            url: url,
            data: sport
        }).then(function successCallback(response) {
            console.log(response);
            $scope.sporturi.push(sport);
        }, function errorCallback(response) {
            console.log(response);
        });
	};
	
	
	function show(type){
		if(type == 'edit'){
			$scope.edit = !$scope.edit;
		}
		if(type == 'openP') {
			$scope.openP = !$scope.openP;
		}
	}
}]);
