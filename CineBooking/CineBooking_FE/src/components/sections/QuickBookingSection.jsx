import { Card, Col, Container, Row } from 'react-bootstrap'

const cinemas = [
  {
    name: 'CineBooking Vincom Đồng Khởi',
    address: '72 Lê Thanh Tôn, Q1, TP.HCM',
    times: ['14:00', '16:30', '19:00'],
  },
  {
    name: 'CineBooking Landmark 81',
    address: '208 Nguyễn Hữu Cảnh, Q.Bình Thạnh, TP.HCM',
    times: ['13:15', '15:45', '18:20', '20:50'],
  },
  {
    name: 'CineBooking Crescent Mall',
    address: '101 Tôn Dật Tiên, Q7, TP.HCM',
    times: ['14:45', '17:15', '19:45', '22:15'],
  },
]

const popular = [
  {
    title: 'Godzilla x Kong',
    score: '9.4',
    stats: '150k lượt đặt',
  },
  {
    title: 'Kung Fu Panda 4',
    score: '9.3',
    stats: '300k lượt đặt',
  },
  {
    title: 'Exhuma',
    score: '9.2',
    stats: '450k lượt đặt',
  },
]

function QuickBookingSection() {
  return (
    <section className="quick-booking" id="lich-chieu">
      <Container>
        <div className="section-title">
          <h2>Rạp & Lịch Chiếu Nhanh</h2>
          <a href="/">Tất cả các rạp</a>
        </div>
        <Row className="g-4">
          <Col lg={8}>
            <Card className="booking-left h-100">
              <Card.Body>
                {cinemas.map((item) => (
                  <div key={item.name} className="schedule-card">
                    <div className="schedule-card-heading">
                      <div>
                        <h3>{item.name}</h3>
                        <p>{item.address}</p>
                      </div>
                    </div>
                    <div className="showtimes">
                      {item.times.map((time) => (
                        <span key={time} className="showtime-pill">
                          {time}
                        </span>
                      ))}
                    </div>
                  </div>
                ))}
              </Card.Body>
            </Card>
          </Col>

          <Col lg={4}>
            <Card className="booking-right h-100">
              <Card.Body>
                <div className="popular-heading">
                  <h3>Xếp Hạng Phổ Biến</h3>
                  <a href="/">Xem tất cả</a>
                </div>
                <div className="popular-list">
                  {popular.map((item, index) => (
                    <div key={item.title} className="popular-item">
                      <span className="popular-rank">{index + 1}</span>
                      <div>
                        <h4>{item.title}</h4>
                        <p>
                          {item.score} • {item.stats}
                        </p>
                      </div>
                    </div>
                  ))}
                </div>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </section>
  )
}

export default QuickBookingSection
