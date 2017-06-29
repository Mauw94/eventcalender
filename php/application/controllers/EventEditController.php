<?php if (!defined('BASEPATH')) exit ('No script acces allowed');
/**
 * Created by PhpStorm.
 * User: Maurits
 * Date: 28-6-2017
 * Time: 14:29
 */
class EventEditController extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->helper('url');
    }

    function index()
    {
        $this->load->view('welcome_message.php');
    }
}