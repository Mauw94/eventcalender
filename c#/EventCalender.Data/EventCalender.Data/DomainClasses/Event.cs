using System;
using System.Net.Sockets;

namespace EventCalender.Data.DomainClasses
{
    public class Event
    {
        public string Note { get; set; }
        public string Description { get; set; }
        public int Id { get; set; }
        public string Time { get; set; }
        public string Date { get; set; }
        public string Subject { get; set; }
    }
}