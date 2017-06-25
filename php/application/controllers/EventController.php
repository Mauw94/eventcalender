<?php
defined('BASEPATH') OR exit('No direct script access allowed');
/**
 * Created by PhpStorm.
 * User: Maurits
 * Date: 25-6-2017
 * Time: 14:18
 */
class EventController extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
    }

    public function index()
    {
        $this->load->model('eventmodel');
        $data['events'] = $this->eventmodel->getAllEvents();
        $this->load->view('eventhomeView', $data);
    }
}