using System.Collections.Generic;
using EventCalender.Data.DomainClasses;

namespace EventCalender.Data
{
    public interface IUserRepository
    {
        IEnumerable<User> GetAll();
        User GetById(int id);
        User Add(User user);
        void Update(User user);
        void Delete(int id);
    }
}