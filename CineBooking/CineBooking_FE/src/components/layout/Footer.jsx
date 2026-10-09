import { Col, Container, Row } from 'react-bootstrap'

function Footer() {
  return (
    <footer className="footer">
      <Container>
        <Row className="footer-grid gy-4">
          <Col md={4}>
            <h4>CineBooking</h4>
            <p>
              Hệ thống đặt vé phim trực tuyến hàng đầu Việt Nam. Mang đến trải nghiệm
              đặt vé nhanh chóng, tiện lợi và an toàn cho mọi khách hàng.
            </p>
          </Col>
          <Col md={2}>
            <h4>CINEBOOKING</h4>
            <a href="/">Giới thiệu</a>
            <a href="/">Tiện ích online</a>
            <a href="/">Thẻ quà tặng</a>
            <a href="/">Tuyển dụng</a>
          </Col>
          <Col md={3}>
            <h4>ĐIỀU KHOẢN SỬ DỤNG</h4>
            <a href="/">Điều khoản chung</a>
            <a href="/">Hướng dẫn giao dịch</a>
            <a href="/">Chính sách thanh toán</a>
            <a href="/">Chính sách bảo mật</a>
          </Col>
          <Col md={3}>
            <h4>CHĂM SÓC KHÁCH HÀNG</h4>
            <p>Hotline: 1900 1234</p>
            <p>hoso@cinebooking.vn</p>
            <p>
              Giờ làm việc: 8:00 - 22:00 tất cả các ngày trong tuần
            </p>
          </Col>
        </Row>
      </Container>
    </footer>
  )
}

export default Footer
