import { Button, Col, Container, Row } from 'react-bootstrap'

function DownloadAppSection() {
  return (
    <section id="tai-app">
      <Container>
        <div className="download-app">
          <Row className="w-100 align-items-center g-3">
            <Col lg={7}>
              <div>
                <h2>Dat Ve Tien Loi Tren Ung Dung CineBooking</h2>
                <p>Dat ve, luu ma QR, nhan thong bao suat chieu va uu dai moi nhat.</p>
                <div className="download-actions">
                  <Button type="button" className="btn btn-dark">
                    App Store
                  </Button>
                  <Button type="button" className="btn btn-dark">
                    Google Play
                  </Button>
                </div>
              </div>
            </Col>
            <Col lg={5} className="d-flex justify-content-lg-end">
              <div className="phone-mockup">
                <div className="phone-screen" />
              </div>
            </Col>
          </Row>
        </div>
      </Container>
    </section>
  )
}

export default DownloadAppSection
