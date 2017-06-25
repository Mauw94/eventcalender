<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<?php echo base_url();?>css/global.css">
    <title>Home</title>
</head>
<body>
<div class="container-fluid">
    <div class="bg-warning">
        <h1>Event Overview</h1>
    </div>
    <div class="bg-success btn-default">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Subject</th>
                <th>Description</th>
                <th>Note</th>
                <th>Day&Time</th>
            </tr>
            </thead>
            <tbody>
            <?php foreach ($events as $event) {
                echo '<tr>';
                echo '<td>' . $event->ID . '</td>';
                echo '<td>' . $event->SUBJECT. '</td>';
                echo '<td>' . $event->DESCRIPTION . '</td>';
                echo '<td>' . $event->NOTE . '</td>';
                echo '<td>' . $event->TIME . '</td>';
                echo '</tr>';
            }
            ?>
            </tbody>
        </table>
    </div>
    <p>web app needs a login system</p>
    <p>description of a subject comes here when you hover over it</p>
    <p>clicking on the name will go to a detailed page of the event</p>
    <p>clicking on delete button will delete an event from the list</p>
</div>
</body>
</html>