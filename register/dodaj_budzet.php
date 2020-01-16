<?php
session_start();

if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $produkt = $_POST['produkt'];
    $cena = $_POST['cena'];
	$id = $_POST['id'];
	

   

    require_once 'connect.php';

$sql = "INSERT INTO budzet(produkt, cena, id) VALUES ('$produkt', '$cena', '$_POST[id]' )";

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