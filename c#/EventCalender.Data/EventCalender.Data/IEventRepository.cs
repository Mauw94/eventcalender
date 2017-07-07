using System.Collections.Generic;
using EventCalender.Data.DomainClasses;

namespace EventCalender.Data
{
    public interface IEventRepository
    {
        IEnumerable<Event> GetAll();
        Event GetById(int id);
        User Add(Event ev);
        void Update(Event ev);
        void Delete(int id);
    }
}