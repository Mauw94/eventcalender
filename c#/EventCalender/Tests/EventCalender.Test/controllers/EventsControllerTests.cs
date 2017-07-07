using System;
using System.Collections.Generic;
using System.Web.Http.Results;
using EventCalender.Controllers;
using EventCalender.Data;
using EventCalender.Data.DomainClasses;
using Moq;
using NUnit.Framework;

namespace EventCalender.Test.controllers
{
    [TestFixture]
    public class EventsControllerTests
    {
        private TestableEventsController _controller;
        private Random _random = new Random();
        
        [SetUp]
        public void Setup()
        {
            _controller = TestableEventsController.CreateInstance();
        }

        [Test]
        public void GetAll_ReturnsEventsFromRepository()
        {
            // Arrange
            var events = new List<Event>()
            {
                new Event(),
                new Event()
            };
            _controller.EventRepositoryMock.Setup(r => r.GetAll()).Returns(() => events);
            
            // Act
            var okResult = _controller.GetAll() as OkNegotiatedContentResult<IEnumerable<Event>>;
            
            // Assert
            Assert.That(okResult, Is.Not.Null);
            Assert.That(okResult.Content, Is.EqualTo(events));
            _controller.EventRepositoryMock.Verify(r => r.GetAll(), Times.AtLeastOnce);
        }
    }

    class TestableEventsController : EventController
    {
        public Mock<IEventRepository> EventRepositoryMock { get; }

        private TestableEventsController(Mock<IEventRepository> eventRepoMock) : base(eventRepoMock.Object)
        {
            EventRepositoryMock = eventRepoMock;
        }

        public static TestableEventsController CreateInstance()
        {
            var eventRepoMock = new Mock<IEventRepository>();
            return new TestableEventsController(eventRepoMock);
        }
    }
}