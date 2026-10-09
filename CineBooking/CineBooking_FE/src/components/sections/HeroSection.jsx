import { Button, Container, Form } from 'react-bootstrap'

const quickFilters = [
  {
    icon: '◴',
    label: 'CHỌN NGÀY',
    options: ['Hôm nay, 24/04', 'Ngày mai, 25/04', 'Cuối tuần'],
  },
  {
    icon: '◉',
    label: 'RẠP',
    options: ['Tất cả các rạp', 'CGV', 'Lotte Cinema', 'Galaxy Cinema'],
  },
  {
    icon: '◍',
    label: 'THỂ LOẠI',
    options: ['Mọi thể loại', 'Hành động', 'Tình cảm', 'Hoạt hình'],
  },
  {
    icon: '◌',
    label: 'NGÔN NGỮ',
    options: ['Tất cả', 'Lồng tiếng', 'Phụ đề'],
  },
]

const heroBanner = {
  badge: 'Phim nổi bật',
  title: 'Mưa đỏ',
  rating: '9.5/10',
  duration: '166 phút',
  genres: 'Hành động, Viễn tưởng',
  description:
    'Paul Atreides hợp lực với Chani và người Fremen khi đang trên con đường trả thù những kẻ đã tiêu diệt gia đình mình. Đối mặt với sự lựa chọn giữa tình yêu của cuộc đời mình và số phận của vũ trụ...',
  image:
    'https://cdn-media.sforum.vn/storage/app/media/doanphuong/mua-do/mua-do-th.jpg',
}

function HeroSection() {
  return (
    <section className="hero-section">
      <div className="hero-banner-shell">
        <div
          className="hero-slide active"
          style={{
            backgroundImage: `url(${heroBanner.image})`,
          }}
        />

        <Container className="hero-banner-container">
          <div className="hero-banner">
            <div className="hero-banner-inner">
              <h1>{heroBanner.title}</h1>
              <div className="hero-meta">
                <span>★ {heroBanner.rating}</span>
                <span>◷ {heroBanner.duration}</span>
                <span>◉ {heroBanner.genres}</span>
              </div>
              <p>{heroBanner.description}</p>
              <div className="hero-actions">
                <Button className="btn btn-primary hero-main-btn">Đặt vé ngay</Button>
                <Button className="btn btn-dark hero-secondary-btn">Xem Trailer</Button>
              </div>
            </div>
          </div>
        </Container>
      </div>

      <Container>
        <div className="quick-filter-row">
          {quickFilters.map((item) => (
            <div key={item.label} className="filter-item">
              <label className="filter-label">
                <span>{item.icon}</span>
                {item.label}
              </label>
              <Form.Select className="filter-select">
                {item.options.map((option) => (
                  <option key={option}>{option}</option>
                ))}
              </Form.Select>
            </div>
          ))}
          <div className="filter-submit-wrap">
            <Button className="btn btn-primary w-100 filter-submit-btn">TÌM KIẾM NHANH</Button>
          </div>
        </div>
      </Container>
    </section>
  )
}

export default HeroSection
