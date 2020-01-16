<?php
//session_start();


if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $imie = $_POST['imie'];
    $nazwisko = $_POST['nazwisko'];
    $numer = $_POST['numer'];
	$id = $_POST['id'];
	

   

    require_once 'connect.php';

$sql = "INSERT INTO goscie(imie, nazwisko, numer, id) VALUES ('$imie', '$nazwisko', '$numer', '$_POST[id]' )";

    if ( mysqli_query($conn, $sql) ) {
        $result["success"] = "1";
        $result["message"] = "success";

        echo json_encode($result);
        mysqli_close($conn);

    } else {

        $result["success"] = "0";
        $result["message"] = "error";

        echo json_encode($result);
        mysqli_close($conn);
    }
}

?>